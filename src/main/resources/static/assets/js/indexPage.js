$(document).ready(function(){
    $.getJSON('/categories/getAllCategories', function(data) {
        let hold = document.getElementsByClassName("col-12 col-md-4 p-5 mt-3");
        let i;
        for (i = 0; i < hold.length; i++) {

            let link = document.createElement('a');
            link.href = 'category/' + data[i].id;
            let image = document.createElement('img');
            image.src = './upload/images/categories/магніти/1.jpg';
            image.className = 'rounded-circle img-fluid border';
            link.appendChild(image);
            let h5 = document.createElement('h5');
            h5.className = 'text-center mt-3 mb-3';
            h5.textContent = data[i].name;
            let p = document.createElement('p');
            p.className = 'text-center';
            let a = document.createElement('a');
            a.text = 'Go Shop';
            a.className = 'btn btn-success';
            a.href = 'category/' + data[i].id;
            p.appendChild(a);

            hold[i].appendChild(link);
            hold[i].appendChild(h5);
            hold[i].appendChild(p);

        }
    });
});