const sortList = document.getElementById("sortingFields");
const weekCheck = document.getElementById("sortingWeek");


if (localStorage.getItem("sort") == null) {
    localStorage.setItem("sort", "W4");
}

if (localStorage.getItem("week") == null) {
    currentDate = new Date();
    startDate = new Date(currentDate.getFullYear(), 0, 1);
    var days = Math.floor((currentDate - startDate) / (24 * 60 * 60 * 1000));
    var weekNumber = Math.ceil(days / 7);

    $.ajax({
        type: "GET",
        url: "/api/week/" + weekNumber,
        dataType: "json",
    }).done(function(result) {
        if (result[weekNumber].tydzien == "nieparzysty") {
            localStorage.setItem("currentWeekType", "TN");
            console.log("nieparzysty");
        }
        else if (result[weekNumber].tydzien == "parzysty") {
            localStorage.setItem("currentWeekType", "TP");
            console.log("parzysty");
        }
        else {
            localStorage.setItem("currentWeekType", "TN");
            console.log("nietypowy lub blad")
        }
        localStorage.setItem("week", localStorage.getItem("currentWeekType"));
        console.log("Sorting by: " + localStorage.getItem("week"));
    });
}

function changeWeek() {
    if (localStorage.getItem("week") == "TN") {
        localStorage.setItem("week", "TP");
      }
      else if (localStorage.getItem("week") == "TP") {
        localStorage.setItem("week", "TN");
      }
}

function urlByRole() {
    if (window.location.href.match("/user")) {
        window.location.href = 'http://localhost:8080/user?sort=' + localStorage.getItem("sort") + '&sort=' + document.querySelector('input[name="chosenWeek"]:checked').value;
    }
    else if (window.location.href.match("/admin")) {
        window.location.href = 'http://localhost:8080/admin?sort=' + localStorage.getItem("sort") + '&sort=' + document.querySelector('input[name="chosenWeek"]:checked').value;
    }
    else {
        window.location.href = 'http://localhost:8080?sort=' + localStorage.getItem("sort") + '&sort=' + document.querySelector('input[name="chosenWeek"]:checked').value;
    }
}

if (localStorage.getItem("week") == "EW") {
    document.getElementById("EW").checked = true;
}
else {
    document.getElementById("weekly").checked = true;
}
document.getElementById("sorting").value = localStorage.getItem("sort");



sortList.addEventListener("change", () => {
    localStorage.setItem("sort", document.getElementById("sorting").value);

    urlByRole();
})

weekCheck.addEventListener("change", () => {
    if (document.querySelector('input[name="chosenWeek"]:checked').value == "EW") {
        localStorage.setItem("week", document.querySelector('input[name="chosenWeek"]:checked').value);
    }
    else {
        localStorage.setItem("week", localStorage.getItem("currentWeekType"));
    }

    urlByRole();
})