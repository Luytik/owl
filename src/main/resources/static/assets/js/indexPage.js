$(document).ready(function(){
    $.getJSON('/categories/getAllCategories', function(dataCategories) {
        let holdCategories = document.getElementsByClassName("col-12 col-md-4 p-5 mt-3");
        let i;
        for (i = 0; i < holdCategories.length; i++) {
            let link = document.createElement('a');
            link.href = 'category/' + dataCategories[i].id;
            let image = document.createElement('img');
            image.src = './upload/images/categories/' + dataCategories[i].name + '/' + dataCategories[i].image;
            image.className = 'rounded-circle img-fluid border';
            link.appendChild(image);
            let h5 = document.createElement('h5');
            h5.className = 'text-center mt-3 mb-3';
            h5.textContent = dataCategories[i].name;
            let p = document.createElement('p');
            p.className = 'text-center';
            let a = document.createElement('a');
            a.text = 'Go Shop';
            a.className = 'btn btn-success';
            a.href = 'category/' + dataCategories[i].id;
            p.appendChild(a);
            holdCategories[i].appendChild(link);
            holdCategories[i].appendChild(h5);
            holdCategories[i].appendChild(p);
        }
    });
    $.getJSON('/products/getLastThreeProducts', function(dataLastThreeProducts) {

        let holdA = document.getElementsByClassName("a h-100");
        let i;
        for(i = 0; i < holdA.length; i++){
            holdA[i].href = "/products/" + dataLastThreeProducts[i].id;
        }
        let holdImgA = document.getElementsByClassName("card-img-top");
        for(i = 0; i < holdImgA.length; i++){
            holdImgA[i].src = './upload/images/products/' + dataLastThreeProducts[i].name + '/' + dataLastThreeProducts[i].mainPictureUrl;
        }

        let holdAh = document.getElementsByClassName("h2 text-decoration-none text-dark");
        for(i = 0; i < holdAh.length; i++){
           holdAh[i].href = "/products/" + dataLastThreeProducts[i].id;
           holdAh[i].textContent = dataLastThreeProducts[i].name;
        }

        let pList = document.getElementsByClassName("card-text");
        for(i = 0; i < pList.length; i++){
            pList[i].textContent = dataLastThreeProducts[i].shortDescriprion;
        }



    });

});