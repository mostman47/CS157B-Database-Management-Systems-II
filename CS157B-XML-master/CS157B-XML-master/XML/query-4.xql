xquery version "1.0";

for $thrd in
	doc("thread.xml")
	//thread

for $frm in
	doc("forum.xml")
	//forum
	
where 
	$thrd/@forum = $frm/name
	
order by 
	$frm/name
	
return
	($frm/name, $thrd/name)