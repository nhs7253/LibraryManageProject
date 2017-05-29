CREATE TABLE wait_list(
	book_id VARCHAR2(30),
	wait_user VARCHAR2(30),
	wait_ranking NUMBER NOT NULL,
	CONSTRAINT pk_wait_list PRIMARY KEY (book_id, wait_user),
	FOREIGN KEY(book_id) REFERENCES book(book_id)
	ON DELETE CASCADE,
	FOREIGN KEY(wait_user) REFERENCES user_management(user_id)
	ON DELETE CASCADE
);

DROP TABLE wait_list;

INSERT INTO wait_list VALUES('897','kite',rental_no_seq.nextVal);

CREATE SEQUENCE wait_ranking_seq;

SELECT * 
FROM wait_list

DELETE FROM wait_list
WHERE book_id = '2' AND wait_user = '2'
		
SELECT w.book_id, w.wait_user, w.wait_ranking,
	   b.book_id, b.title, b.author, b.publisher, b.publish_date, b.rental_state,
	   
	   u.user_id, u.password, u.user_name, u.phone_num, u.email, u.penalty_state
FROM wait_list w, book b, user_management u
WHERE w.book_id = b.book_id(+) AND w.wait_user = u.user_id(+)
      AND w.book_id = '1' AND w.wait_user = '1'
      
      
      	SELECT book_id, title, author, publisher, publish_date, rental_state
			FROM(
				SELECT rownum rnum, book_id, title, author, publisher, publish_date, rental_state
				FROM(
					SELECT book_id, title, author, publisher, publish_date, rental_state FROM book 
					WHERE title LIKE '%'||#{title}||'%'
					ORDER BY title DESC
				)
				WHERE rownum <= #{endItemNum}
			)
			WHERE rnum >= #{beginItemNum}
      
      
      
      
      
      
      SELECT w.book_id, w.wait_user, w.wait_ranking,          b.book_id, b.title, b.author, b.publisher, b.publish_date, b.rental_state,          u.user_id, u.password, u.user_name, u.phone_num, u.email, u.penalty_state   FROM wait_list w, book b, user_management u   WHERE w.book_id = b.book_id(+) AND w.wait_user = u.user_id(+)

      
      
      
SELECT *
FROM wait_list


SELECT book_id, wait_user,
RANK() OVER (PARTITION BY book_id ORDER BY wait_ranking DESC ) as rk 
FROM wait_list
WHERE wait_user IN (SELECT book_id bookid, wait_user user1, wait_ranking ranking FROM wait_list WHERE wait_user = '2')



SELECT book_id, wait_user,
RANK() OVER (PARTITION BY book_id ORDER BY wait_ranking DESC ) as rk 
FROM wait_list

SELECT book_id, wait_user
FROM wait_list
WHERE wait_user IN (
SELECT book_id, wait_user,
RANK() OVER (PARTITION BY book_id ORDER BY wait_ranking DESC ) as rk 
FROM wait_list
WHERE wait_user = '2'
)



SELECT w.book_id, w.wait_user, w.rk, b.title
FROM (
		SELECT book_id, wait_user,
		RANK() OVER (PARTITION BY book_id ORDER BY wait_ranking DESC ) as rk 
		FROM wait_list) w, book b, user_management u
WHERE w.book_id = b.book_id(+) AND w.wait_user = u.user_id AND wait_user = '1'



SELECT b.title, u.user_name, w.rk
FROM (
		SELECT book_id, wait_user,
		RANK() OVER (PARTITION BY book_id ORDER BY wait_ranking DESC ) as rk 
		FROM wait_list) w, book b, user_management u
WHERE w.book_id = b.book_id(+) AND w.wait_user = u.user_id AND wait_user = '1'
ORDER BY b.title


			SELECT title, rank
			FROM(
				SELECT b_title title, w_rk rank, rownum rnum
				FROM(
						SELECT b.title b_title, u.user_name u_user_name, w.rk w_rk
						FROM (
							SELECT book_id, wait_user,
							RANK() OVER (PARTITION BY book_id ORDER BY wait_ranking DESC ) as rk 
							FROM wait_list) w, book b, user_management u
						WHERE w.book_id = b.book_id(+) AND w.wait_user = u.user_id AND wait_user = 'userId2'
						ORDER BY b.title
				)
				WHERE rownum <= '3'
			)
			WHERE rnum >= '1'
			
			
			SELECT title, rank
			FROM(
				SELECT b_title title, w_rk rank, rownum rnum
				FROM(
						SELECT b.title b_title,  w.rk w_rk
						FROM (
							SELECT book_id, wait_user,
							RANK() OVER (PARTITION BY book_id ORDER BY wait_ranking DESC ) as rk 
							FROM wait_list) w, book b
						WHERE w.book_id = b.book_id(+) AND wait_user = 'userId2'
						ORDER BY b.title
				)
				WHERE rownum <= '3'
			)
			WHERE rnum >= '1'
			
			
			
			SELECT userId, name, bookId, title, rank
			FROM(
				SELECT b_book_id bookId, b_title title, w_rk rank, w_wait_user userId, rownum rnum, u_user_name name
				FROM(
						SELECT b.book_id b_book_id, b.title b_title, w.wait_user w_wait_user, w.rk w_rk, u.user_name u_user_name
						FROM (
							SELECT book_id, wait_user,
							RANK() OVER (PARTITION BY book_id ORDER BY wait_ranking ) as rk 
							FROM wait_list) w, book b, user_management u
						WHERE w.book_id = b.book_id(+) AND  w.wait_user = u.user_id(+)
						ORDER BY b.title
				)
				WHERE rownum <= '10'
			)
			WHERE rnum >= '1'

			
			
		SELECT *
		FROM wait_list
		WHERE user_id = 'userId'
		ORDER BY wait_ranking 

		
		select *
		from wait_list
		
		
		
		
SELECT w.book_id, w.wait_user, w.rk, b.title
FROM (
		SELECT book_id, wait_user,
		RANK() OVER (PARTITION BY book_id ORDER BY wait_ranking ) as rk 
		FROM wait_list) w, book b, user_management u
WHERE w.book_id = b.book_id(+) AND w.wait_user = u.user_id




