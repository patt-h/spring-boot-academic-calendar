const sortList = document.getElementById("sortingFields");
const weekCheck = document.getElementById("sortingWeek");

if (localStorage.getItem("sort") == null) {
    localStorage.setItem("sort", "W4");
}

if (localStorage.getItem("week") == null) {
    localStorage.setItem("week", "EW");
}

function urlByRole() {
    if (window.location.href.match("/user")) {
        window.location.href = 'http://localhost:8080/user?sort=' + localStorage.getItem("sort") + '&sort=' + localStorage.getItem("week");
        console.log("user")
    }
    else if (window.location.href.match("/admin")) {
        window.location.href = 'http://localhost:8080/admin?sort=' + localStorage.getItem("sort") + '&sort=' + localStorage.getItem("week");
        console.log("admin")
    }
    else {
        window.location.href = 'http://localhost:8080?sort=' + localStorage.getItem("sort") + '&sort=' + localStorage.getItem("week");
        console.log("guest")
    }
}

document.getElementById(localStorage.getItem("week")).checked = true;
document.getElementById("sorting").value = localStorage.getItem("sort");

sortList.addEventListener("change", () => {
    localStorage.setItem("sort", document.getElementById("sorting").value);

    urlByRole();
})

weekCheck.addEventListener("change", () => {
    localStorage.setItem("week", document.querySelector('input[name="chosenWeek"]:checked').value);

    urlByRole();
})