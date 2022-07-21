const member = {};
window.onload = (e) => {};

// This function is used for form tag without redirect url
// <form id="signup_form" onsubmit="signUp();return false">
function signUp() {
    member["memID"] = document.getElementById("memID").value;
    member["memPassword"] = document.getElementById("memPassword").value;
    member["memEmail"] = document.getElementById("memEmail").value;
    member["memFirstName"] = document.getElementById("memFirstName").value;
    member["memLastName"] = document.getElementById("memLastName").value;
    member["memBirth"] = document.getElementById("memBirth").value;
    member["memCellPhone"] = document.getElementById("memCellPhone").value;
    // member["memPhone"] = document.getElementById("memPhone").value;
    member["memAddress"] = document.getElementById("memAddress").value;
    console.log(member);
    axios
        .post(
            "http://localhost:8080/Proj_Yokult/api/0.01/member/register",
            member
        )
        .then((response) => {
            let msg = response.data["msg"];
            if (msg === "success") {
                sessionStorage.setItem("account", member["memID"]);
                alert(`註冊成功`);
                window.location.replace("../memberCenter.html");
            } else {
                alert("註冊失敗");
            }
        })
        .catch((error) => console.log(error));
}
