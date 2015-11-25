function counterNews() {
    var min = 1;
    var max = 10;
    var counter = document.getElementById("counter");
    var num = parseInt(counter.innerText);
    num = num + parseInt(Math.random() * (max - min) + min);
    counter.innerHTML = num;

}

function start() {
    var min = 1000;
    var max = 10000;
    var timeout = parseInt(Math.random() * (max - min) + min)
    setInterval("counterNews()", timeout)
}