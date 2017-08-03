function dateToStr(date) {
    var str = "";
    str = str + (date.getDate() > 9 ? '' : '0') + date.getDate();
    str = str + "." + (date.getMonth() > 9 ? '' : '0') + (date.getMonth() + 1);
    str = str + "." + date.getFullYear();
    str = str + " " + (date.getHours() > 9 ? '' : '0') + date.getHours();
    str = str + ":" + (date.getMinutes() > 9 ? '' : '0') + date.getMinutes();
    str = str + ":" + (date.getSeconds() > 9 ? '' : '0') + date.getSeconds();
    return str;
}