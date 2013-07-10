xquery version "1.0";

for $thrd in 
	doc("thread.xml")
	//thread
	
let 
	$d := $thrd/@date
	
where 
	contains($d, "January-2013")
	
order by
	$thrd/name
	
return
	($thrd/name)