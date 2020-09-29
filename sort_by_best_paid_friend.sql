select s.name from students s
    inner join friends f on s.id = f.id
    join packages p on p.id = s.id
    inner join packages p_frd on p_frd.id = f.friend_id
    where (p_frd.salary - p.salary) > 0 order by p_frd.salary asc;