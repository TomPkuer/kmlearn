//普通用户导航栏的逻辑操作
$(function(){
    $(".panel-heading").click(function(e){
        /*切换折叠指示图标*/
        $(this).find("span").toggleClass("glyphicon-chevron-down");
        $(this).find("span").toggleClass("glyphicon-chevron-up");
    });
//    //一开始什么也没点击时加载的默认页面
    $('#content-pane').load('ori_manager_content.jsp');
    //var int=self.setInterval("clock()",10000);
    
});
//点击侧边栏跳转
function loadSongList() {
    $('#content-pane').load("ori_song_content.jsp");
}
function loadUserList() {
    $('#content-pane').load("ori_manager_content.jsp");//加载普通用户信息管理界面
}
function loadDevList(){
	$('#content-pane').load("ori_dev_content.jsp");//加载普通设备信息管理界面
}
function loadAndroidList(){
	$('#content-pane').load("ori_dev_android.jsp");
}

function loadLinuxList(){
	$('#content-pane').load("ori_dev_linux.jsp");
}

function clock(){
	var d=new Date();
	var t=d.toLocaleTimeString();
	alert(t);
}
function exit(){
	window.location.href="login.html";

}