$(document).ready(function(){
    let id = window.location.pathname;
    id = id.split("/");
    console.log(id[2]);
    loadContent(id[2]);
});


function loadContent(idProduct){
    $.getJSON('/products/' + idProduct, function(productData) {
        let name = document.getElementById('productName');
        name.textContent = productData.name;
        let description = document.getElementById('description');
        description.textContent = productData.longDescriprion;
        let price = document.getElementById("price");
        price.textContent = productData.price;
        let image = document.getElementById('product-detail');
        image.src = '/upload/images/products/' + productData.name + '/' + productData.mainPictureUrl;
    });
}
