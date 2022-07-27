$(window).on("load", () => {
    //====測試session storage====//
    sessionStorage.setItem(
        "orderlist",
        `[
    {
        "proid": "1",
        "proname": "MARVIS 義大利經典牙膏85ml(銀-亮白)",
        "propicture": "https://raw.githubusercontent.com/Peggy79/first/main/img/000.jpg",
        "quantity": 1,
        "proprice": 339
    },
    {
        "proid": "2",
        "proname": "舒酸定強化琺瑯質兒童牙膏",
        "propicture": "https://raw.githubusercontent.com/Peggy79/first/main/img/images62.jpg",
        "quantity": 2,
        "proprice": 180
    },
    {
        "proid": "3",
        "proname": "舒酸定專業修復牙膏",
        "propicture": "https://raw.githubusercontent.com/Peggy79/first/main/img/images63.jpg",
        "quantity": 5,
        "proprice": 180
    }]`
    );
    sessionStorage.setItem("delivery", "mailing");
    let orderlist = JSON.parse(sessionStorage.getItem("orderlist"));
    orderlist.forEach((order) => {
        addList(order);
    });
    let delivery = sessionStorage.getItem("delivery");
    getDelivery(delivery);
    subtotal();
    totalaccount();
});

function getDelivery(delivery) {
    if (delivery === "pickup") {
        $("#delivery").text("0");
    } else if (delivery === "mailing") {
        $("#delivery").text("50");
    } else if (delivery === "shipping") {
        $("#delivery").text("100");
    }
}

//計算總和
function totalaccount() {
    let total = 0;
    total += parseInt($("#subtotal").text());
    total += parseInt($("#delivery").text());
    $("#total").text(total);
}

// 計算小計
function subtotal() {
    let subtotal = 0;
    $(".total_price").each((i, e) => {
        subtotal += parseInt($(e).text());
    });
    $("#subtotal").text(subtotal);
}

function addList(order) {
    let list = `
    <li class="product_list     
    data-id="${order["proid"]}" 
    data-name="${order["proname"]}"
    data-quantity="${order["quantity"]}"
    data-price="${order["proprice"]}">
    商品名稱：
    <span>${order["proname"]}</span>
    <ul>
        <li>價格：$<span>${order["proprice"] ?? ""}</span></li>
        <li>數量：<span>${order["quantity"] ?? ""}</span></li>
        <li>小計：$<span class="total_price">${
            order["proprice"] * order["quantity"]
        }</span>></li>
    </ul>
    </li>`;
    $("#orderlist").append(list);
}
