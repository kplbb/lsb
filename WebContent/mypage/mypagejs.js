function go_mycart() {
  if (document.formm.quantity.value == "") {
    alert("input quantity.");
    document.formm.quantity.focus();
  } else {
    document.formm.action = "LsbServlet?command=cart_insert";
    document.formm.submit();
  }
}

function go_cart_delete() {
  var count = 0;

  if (document.formm.cseq.length == undefined) {
    if (document.formm.cseq.checked == true) {
      count++;
    }
  }

  for ( var i = 0; i < document.formm.cseq.length; i++) {
    if (document.formm.cseq[i].checked == true) {
      count++;
    }
  }
  if (count == 0) {
    alert("check items to delete");

  } else {
    document.formm.action = "LsbServlet?command=cart_delete";
    document.formm.submit();
  }
}

function go_order_insert() {
  document.formm.action = "LsbServlet?command=order_insert";
  document.formm.submit();
}

function go_order_delete() {
  var count = 0;

  if (document.formm.oseq.length == undefined) {
    if (document.formm.oseq.checked == true) {
      count++;
    }
  }

  for ( var i = 0; i < document.formm.oseq.length; i++) {
    if (document.formm.oseq[i].checked == true) {
      count++;
    }
  }
  if (count == 0) {
    alert("check items to delete");

  } else {
    document.formm.action = "LsbServlet?command=order_delete";
    document.formm.submit();
  }
}

function go_myorder() {
  document.formm.action = "LsbServlet?command=mypage";
  document.formm.submit();
}