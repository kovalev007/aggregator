function downloadNews(rss) {
    showLoading();

    $.post("/DownloadNews", { rss: rss })
        .done(function( data ) {
            getAllNews();
        })
        .fail(function() {
            alert("Error downloading news");
        })
        .always(function() {
            hideLoading();
        });
}

function getAllNews() {
    showLoading();

    $.post("/GetAllNews")
        .done(function( data ) {
            deleteAllNews();
            for (var i = 0; i < data.length; i++) {
                createNews(data[i]);
            }
        })
        .fail(function() {
            alert("Error getting news");
        })
        .always(function() {
            hideLoading();
        });
}

function searchNews() {
    showLoading();

    var search_text = document.getElementById('search_text').value;

    $.post("/SearchNews", { title: search_text })
        .done(function( data ) {
            deleteAllNews();
            for (var i = 0; i < data.length; i++) {
                createNews(data[i]);
            }
        })
        .fail(function() {
            alert("Error searching news");
        })
        .always(function() {
            hideLoading();
        });
}

function createNews(news) {
    $("#news").append(
        "<div style=\"margin: 10px; border-radius: 8px; background: #f0f0f0; border: 1px solid black; padding: 15px;\">" +
            "<div><a href=" + news.link + ">" + news.title + "</a></div>" +
            "<div>" + news.description + "</div>" +
            "<div>" + dateToStr(new Date(news.date)) + "</div>" +
        "</div>");
}

function deleteAllNews() {
    $("#news").empty();
}