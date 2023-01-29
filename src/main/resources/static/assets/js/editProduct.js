$(document).ready(function(){
    let id = window.location.pathname;
    id = id.split("/");
    console.log(id[4]);
    loadContent(id[4]);
});


function loadContent(idProduct){
        let form = document.getElementById('form');
        console.log(idProduct);
        form.action = "/edit/" + idProduct;
    $.getJSON('/products/' + idProduct, function(productData) {
        let name = document.getElementById('name');
        console.log(productData);
        name.value = productData.name;
        let description = document.getElementById('description');
        description.value = productData.description;
        let price = document.getElementById("price");
        price.value = productData.price;
        let mainImage = document.getElementById('previewMainImage');
        mainImage.src = '/upload/images/products/' + productData.cyrillicName + '/' + productData.imageNames[0];
        let additionalImages = document.getElementById('additionalImagesResult');
        let i;
        for(i = 1; i < productData.imageNames.length; i++){
            let image = document.createElement('img');
            image.className = 'thumbnail';
            image.src = '/upload/images/products/' + productData.cyrillicName + '/' + productData.imageNames[i];
            additionalImages.appendChild(image);
        }
    });

}