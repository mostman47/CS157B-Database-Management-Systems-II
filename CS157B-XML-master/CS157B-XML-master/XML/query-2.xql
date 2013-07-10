xquery version "1.0";

for $pst in
	doc("forumPosts.xml")
	//forumPost

for $per in
	doc("user.xml")
	//user

let  $eml := $per/email

where
	$pst/user = $per/name
	
order by 
	$per/name
	
return
	($per/name, $eml, $pst/content)