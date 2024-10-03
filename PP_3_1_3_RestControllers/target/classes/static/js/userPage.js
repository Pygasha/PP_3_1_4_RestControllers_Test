$(async function() {
    await thisUser();
});
async function thisUser() {

    fetch("http://localhost:8080/api/user/getUserInfo")
        .then(res => res.json())
        .then(data => {
            let user = `$(
                <tr>
                    <td>${data.id}</td>
                    <td>${data.username}</td>
                    <td>${data.yearOfBirth}</td>
                    <td>${data.email}</td>
                    <td>${data.roles.map(role => " " + role.name.substring(5))}</td>
                </tr>
            )`;
            $('#userPanelBody').append(user);
        })
}






