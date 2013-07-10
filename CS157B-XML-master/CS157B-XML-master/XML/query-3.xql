xquery version "1.0";

for $pst in 
	doc("forumPosts.xml")
	//forumPost
	
for $thrd in
	doc("thread.xml")
	//thread

where
	$pst/thread = $thrd/name 
	
order by
	$thrd/name
	
return
	($thrd/name, $pst/content, $pst/user)