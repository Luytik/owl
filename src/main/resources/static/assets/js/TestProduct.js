$(document).ready(function(){
    $.getJSON('/testProduct', function(data) {
        let i;
        hold = document.getElementById("data");
        for (i = 0; i < data.length; i++) {
            let pGoodsName = document.createElement("p");
            pGoodsName.innerText = "Назва товару: ";
            let pGoodsNameValue = document.createElement("p");
            pGoodsNameValue.innerText = data[i].name;
            let pGoodsId = document.createElement("p");
            pGoodsId.innerText = " id: ";
            let pGoodsIdValue = document.createElement("p");
            pGoodsIdValue.innerText = data[i].id;
            let br = document.createElement("br");
            let image = document.createElement("img");
            image.src = "/upload/images/" + data[i].name + "/" + data[i].mainPictureUrl;
            hold.appendChild(pGoodsName);
            hold.appendChild(pGoodsNameValue);
            hold.appendChild(pGoodsId);
            hold.appendChild(pGoodsIdValue);
            hold.appendChild(br);
            hold.appendChild(image);
        }
        $("#image").attr("src", "/getpicture");
    });
});