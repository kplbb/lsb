/**
 * 
 */
function go_save() {
  if (document.formm.id.value == "") {
    alert("please input ID.");
    document.formm.id.focus();
  } else if (document.formm.id.value != document.formm.reid.value) {
    alert("please check for repetitiveness.");
    document.formm.id.focus();
  } else if (document.formm.pwd.value == "") {
    alert("please input password.");
    document.formm.pwd.focus();
  } else if ((document.formm.pwd.value != document.formm.pwdCheck.value)) {
    alert("passwords do not match.");
    document.formm.pwd.focus();
  } else if (document.formm.name.value == "") {
    alert("please input name.");
    document.formm.name.focus();
  } else if (document.formm.email.value == "") {
    alert("please input email.");
    document.formm.email.focus();
  } else {
    document.formm.action = "LsbServlet?command=join";
    document.formm.submit();
  } 
}

function idcheck() {
  if (document.formm.id.value == "") {
    alert('input user ID required.');
    document.formm.id.focus();
    return;
  } 
  var url = "LsbServlet?command=id_check_form&id=" 
+ document.formm.id.value;
  window.open( url, "_blank_1",
"toolbar=no, menubar=no, scrollbars=yes, resizable=no, width=330, height=400");
}


function go_next() {
  if (document.formm.okon1[0].checked == true) {
    document.formm.action = "LsbServlet?command=join";  /* join_form */
    document.formm.submit();
  } else if (document.formm.okon1[1].checked == true) {
    alert('agreement required.');
  }
}
