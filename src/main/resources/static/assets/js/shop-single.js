$(document).ready(function(){
    let id = window.location.pathname;
    id = id.split("/");
    loadContent(id[2]);
    let btn = document.getElementById('addtocart');
    let quantity = document.getElementById('var-value');
    btn.onclick = function(){
        addToCart(id[2], quantity.innerHTML);
    };
});


function loadContent(idProduct){
    $.getJSON('/products/' + idProduct, function(productData) {
        let name = document.getElementById('productName');
        name.textContent = productData.name;
        let description = document.getElementById('description');
        description.textContent = productData.description;
        let price = document.getElementById('price');
        price.innerText = productData.price + " грн.";
        let image = document.getElementById('product-detail');
        let base = document.getElementById('carousel_photo');
        image.src = '/upload/images/products/' + productData.cyrillicName + '/' + productData.mainImageName;
        let i;
        for(i = 0; i < productData.imageNames.length; i++){
            let carousel_item = document.createElement('div');
            if (i == 0) {
                carousel_item.className = 'carousel-item active';
            } else {
                carousel_item.className = 'carousel-item';
            }
            let row = document.createElement('div');
            row.className = 'row';
            carousel_item.appendChild(row);
            let j = 0;
            for(j; j < productData.imageNames.length; j++ ){
                let col_4 = document.createElement('div');
                col_4.className = 'col-4';
                row.appendChild(col_4);
                let a = document.createElement('a');
                a.href = '#';
                col_4.appendChild(a);
                let img = document.createElement('img');
                img.className = "card-img img-fluid";
                img.src = '/upload/images/products/' + productData.cyrillicName + '/' + productData.imageNames[j];
                a.appendChild(img);
            }
            base.appendChild(carousel_item);
        }
    });
}

function addToCart(id, quantity){
    var request = new XMLHttpRequest();
    request.open( "GET", "/profile/cart/addtocart/" + id + "?" + "quantity=" + quantity, false );
    request.send(null);
}
