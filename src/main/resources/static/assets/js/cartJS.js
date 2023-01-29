$(document).ready(function () {
    $.getJSON('/profile/cart/getproductsincart', function (productsInCart) {

        let hold = document.getElementById('cargs');
        let i;
        for(i = 0; i < productsInCart.length; i++){
            let cargs_pos = document.createElement('div');
            cargs_pos.className = "a-cargs_position";
            hold.appendChild(cargs_pos);
            let a_cargs_position_image = document.createElement('div');
            a_cargs_position_image.className = "a-cargs_position_image";
            cargs_pos.appendChild(a_cargs_position_image);         
            let img = document.createElement('img');
            img.src = '/upload/images/products/' + productsInCart[i].productForSaleDTO.cyrillicName + 
                        '/' + productsInCart[i].productForSaleDTO.mainImageName;
            a_cargs_position_image.appendChild(img);
            let cargs_position_name = document.createElement('div');
            cargs_position_name.className = "a-cargs_position_name";
            cargs_pos.appendChild(cargs_position_name);
            cargs_position_name.innerHTML = productsInCart[i].productForSaleDTO.name;
            let cargs_position_num = document.createElement('div');
            cargs_position_num.className = "a-cargs_position_num";
            cargs_pos.appendChild(cargs_position_num);
            let inp = document.createElement("input");
            inp.value = productsInCart[i].quantity;
            inp.min = "1";
            cargs_position_num.appendChild(inp);
            let cargs_position_price = document.createElement('div');
            cargs_position_price.className = "a-cargs_position_price";
            cargs_pos.appendChild(cargs_position_price);
            cargs_position_price.innerHTML = productsInCart[i].productForSaleDTO.price;
            let a = document.createElement('a');
            a.className = "btn btn-success text-white mt-2 a-cargs_position_btn";
            a.href = '/profile/cart/deleteproductfromcart/' + productsInCart[i].id;
            let i_tag = document.createElement('i');
            i_tag.className = "far fa-red fa-window-close";
            a.appendChild(i_tag);
            cargs_pos.appendChild(a); 
        }
        let a_btn = document.createElement('a');
            a_btn.text = 'оформити замовлення';
            a_btn.className = 'btn btn-success btn-lg';
            a_btn.style = 'text-align:center';
            a_btn.href = '/profile/cart/placingorder';
            hold.appendChild(a_btn);
    });
});