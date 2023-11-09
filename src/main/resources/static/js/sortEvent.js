const sortList = document.getElementById("sortingFields");
const weekCheck = document.getElementById("sortingWeek");

if (localStorage.getItem("sort") == null) {
    localStorage.setItem("sort", "W4");
}

else if (localStorage.getItem("week") == null) {
    localStorage.setItem("week", "EW");
}

document.getElementById(localStorage.getItem("week")).checked = true;
document.getElementById("sorting").value = localStorage.getItem("sort");

sortList.addEventListener("change", () => {
    localStorage.setItem("sort", document.getElementById("sorting").value);
    window.location.href = 'http://localhost:8080/?sort=' + localStorage.getItem("sort") + '&sort=' + localStorage.getItem("week");
})

weekCheck.addEventListener("change", () => {
    localStorage.setItem("week", document.querySelector('input[name="chosenWeek"]:checked').value)
    window.location.href = 'http://localhost:8080/?sort=' + localStorage.getItem("sort") + '&sort=' + localStorage.getItem("week");
})