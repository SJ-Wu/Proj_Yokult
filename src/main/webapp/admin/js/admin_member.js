window.onload = (e) => {
    // memberList initialization
    axios
        .get("http://localhost:8080/Proj_Yokult/api/0.01/member")
        .then((response) => {
            let msg = response.data["msg"];
            if (msg === "success") {
                let members = response.data["members"];
                console.log(members);
                members.forEach((member) => {
                    addList(member);
                });
            } else {
                console.log(response.data["msg"]);
            }
        })
        .catch((error) => console.log(error));

    // Remove member
    $("#memberList").on("click", "#btn_delete_member", (e) => {
        if (confirm("確定清除嗎?")) {
            let member_id = $(e.target).closest("tr").data("id");
            console.log(member_id);
            let removeMember = {};
            removeMember["memID"] = member_id;
            console.log(removeMember);
            axios
                .delete(
                    "http://localhost:8080/Proj_Yokult/api/0.01/member/remove",
                    { data: removeMember }
                )
                .then((response) => {
                    let msg = response.data["msg"];
                    if (msg === "success") {
                        $(e.target)
                            .closest("tr")
                            .fadeOut(1000, () => {
                                $(e.target).closest("tr").remove();
                            });
                    } else {
                        console.log(response.data["msg"]);
                    }
                })
                .catch((error) => console.log(error));
        }
    });
};
function addList(member) {
    let list = `<tr data-id="${member["memID"]}">
        <td>${member["memID"]}</td>
        <td>${member["memEmail"] ?? ""}</td>
        <td>${
            (member["memLastName"] ?? "") + (member["memFirstName"] ?? "")
        }</td>
        <td>${member["memBirth"] ?? ""}</td>
        <td>${member["memCellPhone"] ?? ""}</td>
        <td>${member["memAddress"] ?? ""}</td>
        <td><button class="btn-xs btn-light" id="btn_reset_password">重設密碼</button>
            <button class="btn-xs btn-light" id="btn_delete_member">刪除會員</button>
        </td>
    </tr>`;
    $("#memberList").append(list);
}
