$(document).ready(function(){
    $.getJSON('/categories/getAllCategories', function(dataCategories) {
        let hold = document.getElementById('categroiesList');
        let i;
        for (i = 0; i < dataCategories.length; i++) {
            let a = document.createElement('a');
            a.href = 'category/' + dataCategories[i].id;
            a.className = 'collapsed d-flex justify-content-between h3 text-decoration-none';
            let name = dataCategories[i].name;
            name = name.charAt(0).toUpperCase() + name.slice(1);
            a.text = name;
            let li = document.createElement('li');
            li.className = 'pb-3';
            li.appendChild(a);
            hold.appendChild(li);
        }
    });
    loadPages();
    loadProducts(0);
});

function loadPages(){
    $.getJSON('/products/count', function(products){
        let holdPages = document.getElementById("pages");
        let pageCount = products.quantity / 9 + (products.quantity % 9 > 0 ? 1 : 0);
        holdPages.textContent = '';
        pageCount = Math.floor(pageCount);
        let i;
        for(i = 0; i < pageCount; i++){
            let liPages = document.createElement('li');
            liPages.className = 'page-item';
            let aPages = document.createElement('a');
            aPages.className = 'page-link rounded-0 mr-3 shadow-sm border-top-0 border-left-0 text-dark';
            aPages.text = i;
            console.log(i);
            aPages.onclick = function () {loadProducts(parseInt(aPages.text))};
            liPages.appendChild(aPages);
            holdPages.appendChild(liPages);
        }
    });
}

function loadProducts(page) {
    console.log(page);
    $.getJSON('/products/all?page=' + page, function(dataProducts) {
        let hold = document.getElementById('shoplist');
        hold.textContent = '';
        let i;
        for (i = 0; i < dataProducts.length; i++) {
            let col_md_4 = document.createElement('div');
            col_md_4.className = "col-md-4";
            let card_md_4_product_wap_roundled_0 = document.createElement('div');
            card_md_4_product_wap_roundled_0.className = "card mb-4 product-wap rounded-0";
            let card_rounded_0 = document.createElement('div');
            card_rounded_0.className = "card rounded-0";
            let img = document.createElement('img');
            img.className = 'card-img rounded-0 img-fluid';
            img.src = './upload/images/products/' + dataProducts[i].name + '/' + dataProducts[i].mainPictureUrl;
            let card_img = document.createElement('div');
            card_img.className = 'card-img-overlay rounded-0 product-overlay d-flex align-items-center justify-content-center';
            let ul = document.createElement('ul');
            ul.className = 'list-unstyled';
            //far fa eye
            let liEye = document.createElement('li');
            let aEye = document.createElement('a');
            aEye.className = 'btn btn-success text-white mt-2';
            aEye.href = "/products/" + dataProducts[i].id;
            let iEye = document.createElement('i');
            iEye.className = 'far fa-eye';
            aEye.appendChild(iEye);
            liEye.appendChild(aEye);
            ul.appendChild(liEye);
            let liCart = document.createElement('li');
            let aCart = document.createElement('a');
            aCart.className = 'btn btn-success text-white mt-2';
            aCart.href = "/products/" + dataProducts[i].id;
            let iCart = document.createElement('i');
            iCart.className = 'fas fa-cart-plus';
            aCart.appendChild(iCart);
            liCart.appendChild(aCart);
            ul.appendChild(liCart);
            card_img.appendChild(ul);
            card_rounded_0.appendChild(img);
            card_rounded_0.appendChild(card_img);
            card_md_4_product_wap_roundled_0.appendChild(card_rounded_0);
            col_md_4.appendChild(card_md_4_product_wap_roundled_0);
            //div card body
            let div_card_body = document.createElement('div');
            div_card_body.className = 'card-body';
            let aCardBody = document.createElement('a');
            aCardBody.className = 'h3 text-decoration-none';
            aCardBody.href = "/products/" + dataProducts[i].id;
            aCardBody.text = dataProducts[i].name;
            div_card_body.appendChild(aCardBody);
            let pCardBody = document.createElement('p');
            pCardBody.className = 'text-center mb-0';
            pCardBody.textContent = dataProducts[i].price + ' грн';
            div_card_body.appendChild(pCardBody);
            card_md_4_product_wap_roundled_0.appendChild(div_card_body);
            hold.appendChild(col_md_4);
        }
    });
}