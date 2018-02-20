var x=0;
var prevX=0;
var nameArr=[];
var quoteArr=[];

$(document).ready(function() {
    $("#prevBtn").on("click", function() {
        getPrev();
        setBoxColor();
    });
    $("#nextBtn").on("click", function() {
        getNext();
        setBoxColor();
    });
    init();
});
function init() {
    $.ajax({
        type: "GET",
        url: "/shoutoutlist",
        success: function (data) {
            buildList(data.shoutouts);
        }
    });
}
function buildList(data){
    for(var i=0; i < data.length; i++){
        nameArr[i] = data[i].name;
        quoteArr[i] = data[i].quote;
    }
    // set first name, quote and green box
    x=0;
    updateNameQuote();
    setBoxColor();
}
function updateNameQuote(){
    $("#textName").text(nameArr[x]);
    $("#textQuote").text(quoteArr[x]);
}
function getPrev(){
    prevX = x;
    if (x == 0){
        x = (nameArr.length-1);
    } else {
        x--;
    }
    updateNameQuote();
}
function getNext(){
    prevX = x;
    if (x == (nameArr.length-1)){
        x = 0;
    } else {
        x++;
    }
    updateNameQuote();
}
function setBoxColor() {
    $("#bx" + prevX).removeClass("greenOn");
    $("#bx" + x).addClass("greenOn");
}