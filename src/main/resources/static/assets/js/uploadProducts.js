const addProduct = (ev) => {
    ev.preventDefault();
    let productDTO = {
        name: document.getElementById('name').value,
        shortDescriprion: document.getElementById('shortDescriprion').value,
        longDescriprion: document.getElementById('longDescriprion').value,
        price: document.getElementById('price').value,
        categories: [

        ]
    }

    var checkboxes = document.querySelectorAll('input[id^="category"]');
    for (var i = 0; i < checkboxes.length; i++) {
        if (checkboxes[i].checked == true) {
            productDTO.categories.push(checkboxes[i].value);
        }
    }
    document.forms[0].reset();

    //sending data to server
    var xhr = new XMLHttpRequest();
    var url = "/upload";
    xhr.open("POST", url, true);
    xhr.setRequestHeader("Content-Type", "application/json");
    var data = JSON.stringify(productDTO);
    xhr.send(data);

}
document.addEventListener('DOMContentLoaded', () => {
    document.getElementById('btn').addEventListener('click', addProduct);
});