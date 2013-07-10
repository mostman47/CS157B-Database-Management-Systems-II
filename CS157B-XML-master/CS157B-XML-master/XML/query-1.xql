xquery version "1.0";

for $thrd in 
	doc("thread.xml")
	//thread

where
	contains($thrd/@forum, "Computer Forum")

return
	$thrd/name
