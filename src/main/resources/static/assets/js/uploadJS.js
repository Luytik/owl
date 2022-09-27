$(document).ready(function(){
    $.getJSON('/getAllCategories', function(data) {
        let hold = document.getElementById("checkbox");
        let i;
        for (i = 0; i < data.length; i++) {
            let checkbox = document.createElement('input');
            checkbox.type = "checkbox";
            checkbox.name = 'categories';
            checkbox.value = data[i];
            checkbox.id = 'category' + i;
            let label = document.createElement('label');
            label.htmlFor = i;
            label.appendChild(document.createTextNode(data[i]));
            let br = document.createElement('br');
            hold.appendChild(checkbox);
            hold.appendChild(label);
            hold.appendChild(br);
        }
    });
});


