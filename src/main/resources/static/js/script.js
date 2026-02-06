console.log("Script tag loaded");
//get  theme from localStorage

function getTheme(){
    let theme= localStorage.getItem("theme");
    return theme? theme : "light";
}

let currentTheme=getTheme();
changeTheme();

//todo
function changeTheme(){
//console.log(currentTheme);
document.querySelector('html').classList.add(currentTheme);
const changeThemeButton=document.querySelector('#theme_change');
changeThemeButton.addEventListener("click", (event) =>{
    const oldTheme= currentTheme;
    if(currentTheme=="dark"){
         currentTheme="light"
    }else{
         currentTheme="dark"
    }

    setTheme(currentTheme);
    //remove the old theme
    document.querySelector('html').classList.remove(oldTheme);
    //update the current theme
    document.querySelector('html').classList.add(currentTheme);

});

//set the listener to change the theme
}

//set theme to localStorage
function setTheme(theme){
    localStorage.setItem("theme", theme);

} 

