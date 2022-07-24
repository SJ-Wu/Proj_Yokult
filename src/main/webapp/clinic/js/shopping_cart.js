window.onload = (e) => {
    let orederlist = JSON.parse(sessionStorage.getItem("orderlist"));
    orederlist.forEach((order) => {
        addList(order);
    });
    subtotal();
    // memberList initialization
    // axios
    //     .get("http://localhost:8080/Proj_Yokult/api/0.01/member")
    //     .then((response) => {
    //         let msg = response.data["msg"];
    //         if (msg === "success") {
    //             let members = response.data["members"];
    //             console.log(members);
    //             members.forEach((member) => {
    //                 addList(member);
    //             });
    //         } else {
    //             console.log(response.data["msg"]);
    //         }
    //     })
    //     .catch((error) => console.log(error));

    /*-------------------
		Quantity change 數量遞增遞減
	--------------------- */
    $("#shoppingcart_orderlist").on("click", ".qtybtn", function () {
        var $button = $(this);
        var oldValue = $button.parent().find("input").val();
        if ($button.hasClass("inc")) {
            var newVal = parseFloat(oldValue) + 1;
        } else {
            // Don't allow decrementing below zero
            if (oldValue > 0) {
                var newVal = parseFloat(oldValue) - 1;
            } else {
                newVal = 0;
            }
        }
        $button.parent().find("input").val(newVal);
        // Get product price by jquery.
        let product_price = $button
            .parent()
            .parent()
            .parent()
            .prev()
            .find(".product_price")
            .text();
        // Get total price by jquery.
        let total_price = $button
            .parent()
            .parent()
            .parent()
            .next()
            .find(".total_price")
            .text(product_price * newVal);
        console.log(newVal);
        console.log(product_price, total_price);
        subtotal();
        totalaccount();
    });
    //從購車中刪除
    $("#shoppingcart_orderlist").on("click", ".btn_delete", (e) => {
        $(e.target)
            .closest("tr")
            .fadeOut(1000, () => {
                $(e.target).closest("tr").remove();
            });
        subtotal();
        totalaccount();
    });

    // 運費選擇
    document
        .getElementById("delivery_form")
        .addEventListener("click", function (event) {
            if (event.target && event.target.matches("input[type='radio']")) {
                document.getElementById("delivery").innerText =
                    event.target.value;
            }
            totalaccount();
        });
    // 計算總和
    totalaccount();
    // //   加入購物車
    // $("#the_btn1").on("click", function () {
    //     // 取得欄位的值
    //     alert($("select[name='the_select']").text());
    // });
};

//計算總和
function totalaccount() {
    let total = 0;
    total += parseInt(document.getElementById("subtotal").innerText);
    total += parseInt(document.getElementById("delivery").innerText);
    document.getElementById("total").innerText = total;
}

// 計算小計
function subtotal() {
    let subtotal = 0;
    document.querySelectorAll(".total_price").forEach((e) => {
        subtotal += parseInt(e.innerText);
    });
    console.log(subtotal);
    document.getElementById("subtotal").innerText = subtotal;
}

// 加入列表
function addList(order) {
    let list = `<tr>
    <td class="shoping_cart_item">
        <img src="#" alt=""/>
        <h5>${order["proid"] ?? ""}</h5>
    </td>
    <td class="shoping_cart_price">NT$<span class="product_price">${
        order["proprice"] ?? ""
    }</span></td>
    <td class="shoping_cart_quantity">
        <div class="quantity">
            <div class="pro-qty">
                <i class="fa-solid fa-minus dec qtybtn"></i>
                <input type="text" value="${order["quantity"] ?? ""}"/>
                <i class="fa-solid fa-plus inc qtybtn"></i>
            </div>
        </div>
    </td>
    <td class="shoping_cart_total">NT$<span class="total_price">${
        order["proprice"] * order["quantity"]
    }</span></td>
    <td class="shoping_cart_item_close">
        <span class="fa-solid fa-xmark btn_delete"></span>
    </td>
    </tr>`;
    $("#shoppingcart_orderlist").append(list);
}

// sessionStorage.setItem(
//     "orderlist",
//     `[
//     {
//         "proid": "MARVIS 義大利經典牙膏85ml(銀-亮白)",
//         "quantity": 1,
//         "proprice": 339
//     },
//     {
//         "proid": "BlackIsWhite酷黑淨白牙刷組",
//         "quantity": 2,
//         "proprice": 450
//     },
//     {
//         "proid": "舒酸定強效抗敏牙膏",
//         "quantity": 5,
//         "proprice": 180
//     }]`
// );
