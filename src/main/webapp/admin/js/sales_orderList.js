var product = []; //var是函式作用域
window.onload = function () {
    //function(函數)將大程式分成許多個小的，方便管理及偵錯，減少重複
    getProducts(null, null); //get攝取值
};

// function search() {
//     //search搜尋資料
//     let productName = $("#productNameInput").val(); //let區塊作用域，就是說只能在自己的區域宣告變數
//     let category = $("#category").val(); //category聲明私有方法, $函數用來自定函數寫一個功能
//     getProducts(productName, category);
// }

// function reset() { //reset重整
//     $("#productNameInput").val("");
//     $("#category").val("");
// }

function getProducts(productName, category) {
    let requestOptions = {
        method: "GET",
        redirect: "follow",
    };

    let url = new URL("http://localhost:8080/Proj_Yokult/api/0.01/orderList/");
    if (productName != null && productName != "") {
        url.searchParams.append("productName", productName);
    }
    if (category != null && category != "") {
        url.searchParams.append("category", category);
    }

    fetch(url, requestOptions)
        .then((response) => response.text())
        .then((text) => {
            const rep = JSON.parse(text);

            products = rep.products;

            removeAllProducts();

            addProducts(rep.products);
        })
        .catch((error) => console.log("error", error));
}

// function removeAllProducts() {
//     $("#example2>tbody").remove();
// }

function addProducts(products) {
    products.forEach((product, idx) => {
        let productlistHtml = "";

        productlistHtml = `
      <tbody>
        <tr>
          <td>${product.proID}</td>
          <td>${product.proName}</td>
          <td>${product.proStock}</td>
          <td>${product.proPrice}</td>
          <td>${product.proSpecs}</td>
          <td>${product.proBrand}</td>
          <td>${product.proCategory}</td>
          <td>0</td>
          <td>
            <button
              class="btn-xs btn-light"
              onclick="setModalData(${idx})"
              data-toggle="modal"
              data-target="#editProduct"
            >
              編輯
            </button>
          </td>
        </tr>
      </tbody>`;

        $("#example2").prepend(productlistHtml);
    });
}

function setModalData(idx) {
    let product = products[idx];

    if (product == null || product == undefined) {
        return;
    }

    $("#proID").val(product.proID);
    $("#proName").val(product.proName);
    $("#proStock").val(product.proStock);
    $("#proPrice").val(product.proPrice);
    $("#proSpecs").val(product.proSpecs);
    $("#proBrand").val(product.proBrand);
    $("#proCategory").val(product.proCategory);
}

// function saveProduct() {
//     var raw = JSON.stringify({
//         proID: $("#proID").val(),
//         proName: $("#proName").val(),
//         proStock: $("#proStock").val(),
//         proPrice: $("#proPrice").val(),
//         proSpecs: $("#proSpecs").val(),
//         proBrand: $("#proBrand").val(),
//         proCategory: $("#proCategory").val(),
//     });

//     var requestOptions = {
//         method: "POST",
//         body: raw,
//         redirect: "follow",
//     };

fetch("http://localhost:8080/Proj_Yokult/api/0.01/orderList/", requestOptions)
    .then((response) => response.text())
    .then((result) => search())
    .catch((error) => console.log("error", error));

$("#proID").val();
$("#proName").val();
$("#proStock").val();
$("#proPrice").val();
$("#proSpecs").val();
$("#proBrand").val();
$("#proCategory").val();

$("#editProduct").modal("hide");
// }
