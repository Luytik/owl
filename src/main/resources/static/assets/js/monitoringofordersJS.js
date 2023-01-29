$(document).ready(function () {
    $.getJSON('/admin/getallorders', function (allOrders) {

        let hold = document.getElementById('cargs');
        let i;
        console.log(allOrders.length);
        for(i = 0; i < allOrders.length; i++){
            let cargs_pos = document.createElement('div');
            cargs_pos.className = "a-cargs_position";
            hold.appendChild(cargs_pos);

            let cargs_position_order_name = document.createElement('div');
            cargs_position_order_name.className = "a-cargs_position_order";
            cargs_pos.appendChild(cargs_position_order_name);
            cargs_position_order_name.innerHTML = allOrders[i].firstName;

            let cargs_position_order_sname = document.createElement('div');
            cargs_position_order_sname.className = "a-cargs_position_order";
            cargs_pos.appendChild(cargs_position_order_sname);
            cargs_position_order_sname.innerHTML = allOrders[i].secondName;

            let cargs_position_order_tel = document.createElement('div');
            cargs_position_order_tel.className = "a-cargs_position_order";
            cargs_pos.appendChild(cargs_position_order_tel);
            cargs_position_order_tel.innerHTML = allOrders[i].telNumber;

            let cargs_position_order_address = document.createElement('div');
            cargs_position_order_address.className = "a-cargs_position_order";
            cargs_pos.appendChild(cargs_position_order_address);
            cargs_position_order_address.innerHTML = allOrders[i].deliveryAddress;

            let cargs_position_order_company = document.createElement('div');
            cargs_position_order_company.className = "a-cargs_position_order";
            cargs_pos.appendChild(cargs_position_order_company);
            cargs_position_order_company.innerHTML = allOrders[i].deliveryCompany;

            let cargs_position_order_date = document.createElement('div');
            cargs_position_order_date.className = "a-cargs_position_order";
            cargs_pos.appendChild(cargs_position_order_date);
            cargs_position_order_date.innerHTML = allOrders[i].date;

            let cargs_position_order_status = document.createElement('div');
            cargs_position_order_status.className = "a-cargs_position_order";
            cargs_pos.appendChild(cargs_position_order_status);
            cargs_position_order_status.innerHTML = allOrders[i].status;

            let a = document.createElement('a');
            a.className = "btn btn-success text-white mt-2 a-cargs_position_btn";
            a.href = "/updateOrder/" + allOrders[i].id;
            let i_tag = document.createElement('i');

            i_tag.className = "far fa-red fa-window-close";
            a.appendChild(i_tag);
            cargs_pos.appendChild(a); 

            let a_products = document.createElement('a');
            a.innerHTML = "product list";
            a.href = "/admin/productsinorder/" + allOrders[i].id;


        }
        let a_btn = document.createElement('a');
            a_btn.text = 'оформити замовлення';
            a_btn.className = 'btn btn-success btn-lg';
            a_btn.style = 'text-align:center';
            a_btn.href = '/profile/cart/placingorder';
            hold.appendChild(a_btn);
    });
});
