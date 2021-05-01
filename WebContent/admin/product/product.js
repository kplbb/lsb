function NumFormat(t) // currency won /원 단위, 찍어주기
{
	s = t.value;
	s = s.replace(/\D/g, '');
	l = s.length - 3;
	while (l > 0) {
		s = s.substr(0, l) + ',' + s.substr(l);
		l -= 3;
	}
	t.value = s;
	return t;
}

function go_ab() // retail-production price calculation /판매가-원가=순매출을 replace해서 계산해 준다.
{
	var theForm = document.frm;
	//var a = theForm.price2.value.replace(/,/g, '');
	//var b = theForm.price1.value.replace(/,/g, '');
	var a = theForm.price2.value;
	var b = theForm.price1.value;
	var ab = parseInt(a) - parseInt(b);
	theForm.price3.value = ab;
}

// determine whether input is correct
// used in productWrite.jsp
function go_save() 
{
	var theForm = document.frm;
	
	if (theForm.kind.value == '') {
		alert('select product category.');
		theForm.kind.focus();
	 } else if (theForm.name.value == '') {
		alert('enter product name .');
		theForm.name.focus();  
	} else if (theForm.price1.value == '') {
		alert('enter product prod. price.');
		theForm.price1.focus();
	} else if (theForm.price2.value == '') {
		alert('enter product retail price.');
		theForm.price2.focus();
	} else if (theForm.content.value == '') {
		alert('enter product detail.');
		theForm.content.focus();
	} else if (theForm.image1.value == '') {
		alert('select images of product.');
		theForm.image.focus();
	} else {
		theForm.encoding = "multipart/form-data";
		theForm.price1.value = removeComma(theForm.price1);
		theForm.price2.value = removeComma(theForm.price2);
		theForm.price3.value = removeComma(theForm.price3);

		// input value from productWrite.jsp 
		// to save into DB move to page product_save.jsp
		// send inputed product code in the form of query string
		// make product code folder and upload images there
		theForm.action = "LsbServlet?command=admin_product_write";
		theForm.submit();
	}
}

function removeComma(input) // ,is removed and replace value 
{
	return input.value.replace(/,/gi, "");
}
// used in productWrite.jsp, moves to productList
function go_mov()
{
	var theForm = document.frm;
	theForm.action = "LsbServlet?command=admin_product_list";
	theForm.submit();
}
//projectList.jsp
function go_search() {
	var theForm = document.frm;
	theForm.action =  "LsbServlet?command=admin_product_list_by_name"; /*admin_product_list*/
	theForm.submit();
}

function go_total() {
	var theForm = document.frm;
	theForm.key.value = "";
	theForm.action =  "LsbServlet?command=admin_product_list";
	theForm.submit();
}

function go_detail(tpage, pseq) {
	var theForm = document.frm;
	// When returning to the product list from the product detail view page, go to the current page
	// In order to be able to return, the current page number is passed as a query string.
	theForm.action =  "LsbServlet?command=admin_product_detail&tpage=" +
	                  tpage+"&pseq="+pseq;
	
	theForm.submit();
}

function go_wrt() {
	var theForm = document.frm;
	theForm.action = "LsbServlet?command=admin_product_write_form";
	theForm.submit();
}
// **************** productDetail.jsp
function go_list(tpage) {
	var theForm = document.frm;
	//Move to the product list, but pass the current page as a query string.
	theForm.action = "LsbServlet?command=admin_product_list&tpage=" + tpage;
	theForm.submit();
}
// **************** productDetail.jsp
function go_mod(tpage, pseq) {
	var theForm = document.frm;
	//Put the current page as a query string.
	theForm.action = "LsbServlet?command=admin_product_update_form&tpage=" + 
		              tpage+"&pseq="+pseq;
	theForm.submit();
}

function go_mod_save(pseq) {
	var theForm = document.frm;

	if (theForm.kind.value == '') {
		alert('select product category.');
		theForm.kind.focus();
	} else if (theForm.pname.value == '') {
		alert('enter product name');
		theForm.pname.focus();
	} else if (theForm.price1.value == '') {
		alert('enter product prod. price.');
		theForm.price1.focus();
	} else if (theForm.price2.value == '') {
		alert('enter product retail price.');
		theForm.price2.focus();
	} else if (theForm.content.value == '') {
		alert('enter product detail');
		theForm.content.focus();
	} else {
		if (confirm('save changes made?')) {
			// [1] To fill a 1 in the useyn column of the products table that the product is not deleted but not used.
			// Assign 1 to the useyns hidden tag.
			if (theForm.useyn.checked == true) {
				theForm.useyn.value = "y";
			}
			if(theForm.bestyn.checked == true) {
				theForm.bestyn.value = "y";
			}
			theForm.encoding = "multipart/form-data";
			// theForm.seq.value=seq;
			theForm.price1.value = removeComma(theForm.price1);
			theForm.price2.value = removeComma(theForm.price2);
			theForm.price3.value = removeComma(theForm.price3);
			// [2] To the product_modsave.jsp page that modifies product information in the products table
			// Move but pass the product code. This is because a folder is created with the product code and image files are uploaded there.		
			theForm.action = "LsbServlet?command=admin_product_update";
			theForm.submit();
		}
	}
}

function go_mod_mov(tpage, pseq) {
	var theForm = document.frm;
	theForm.action = 'LsbServlet?command=admin_product_detail&tpage=' + tpage + "&pseq=" + pseq;
	theForm.submit();
}
