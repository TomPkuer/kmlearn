//超级用户导航栏操作
$(function(){
    $(".panel-heading").click(function(e){
        /*切换折叠指示图标*/
        $(this).find("span").toggleClass("glyphicon-chevron-down");
        $(this).find("span").toggleClass("glyphicon-chevron-up");
    });
//    //一开始什么也没点击时加载的默认页面
    $('#content-pane').load('ori_manager_content.jsp');
    alert("欢迎进入超级管理员界面！");
});
function loadSongList() {
    $('#content-pane').load("sup_song_content.jsp");
}
function loadUserList() {
    $('#content-pane').load("sup_manager_content.jsp");
}
function loadDevList() {
    $('#content-pane').load("sup_dev_content.jsp");
}
function loadAndroidList(){
	$('#content-pane').load("sup_dev_android.jsp");
}

function loadLinuxList(){
	$('#content-pane').load("sup_dev_linux.jsp");
}
function exit(){
	window.location.href="login.html";
}
