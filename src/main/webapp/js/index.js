function loadPage() {
    getAllNews();
}

function downloadNews(rss) {
    showLoading();

    jQuery.post("/DownloadNews", { rss: rss })
        .done(function( ) {
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

    var search_text = document.getElementById('search_text').value;

    jQuery.post("/GetAllNews", { title: search_text })
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

function createNews(news) {
    jQuery('<div/>', {
        name: 'news_div',
        style: 'margin: 10px; border-radius: 8px; background: #f0f0f0; border: 1px solid black; padding: 15px;'
    }).appendTo('#news');

    jQuery('<div/>', {
        name: 'news_title'
    }).appendTo(jQuery(jQuery("#news div[name=news_div]").last()));

    jQuery('<a/>', {
        href: news.link,
        html: news.title,
        target: '_blank'
    }).appendTo(jQuery(jQuery("#news div[name=news_title]").last()));

    jQuery('<div/>', {
        name: 'news_description',
        html: news.description
    }).appendTo(jQuery(jQuery("#news div[name=news_div]").last()));

    jQuery('<div/>', {
        name: 'news_date',
        html: dateToStr(new Date(news.date))
    }).appendTo(jQuery(jQuery("#news div[name=news_div]").last()));
}

function deleteAllNews() {
    jQuery("#news").empty();
}