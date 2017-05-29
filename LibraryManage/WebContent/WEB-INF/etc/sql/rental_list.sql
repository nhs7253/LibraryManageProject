CREATE TABLE rental_list(
	rental_no NUMBER PRIMARY KEY,
	user_id VARCHAR2(30) NOT NULL,
	book_id VARCHAR2(30) NOT NULL,
	rental_start DATE,
	rental_end DATE,
	FOREIGN KEY(user_id) REFERENCES user_management(user_id)
	ON DELETE CASCADE
);

CREATE SEQUENCE rental_no_seq;
drop sequence rental_no_seq;

		select 
			rental_no,
		user_id,
		book_id,
		rental_start,
		rental_end
		FROM RENTAL_LIST
		WHERE rental_no = 3;

select * from rental_list where book_id = 'P003W0005002';


		
		
INSERT INTO rental_list VALUES(rental_no_seq.nextVal, '사용자1', '897', SYSDATE, null);
INSERT INTO rental_list VALUES(rental_no_seq.nextVal, 'ㅂㅂㅂ', '새새책', SYSDATE, null);
DELETE FROM rental_list WHERE user_id='user01'

select * from rental_list where rental_no =3;

DELETE TABLE rental_list;

DROP TABLE rental_list;

INSERT INTO rental_list VALUES(rental_no_seq.nextVal, 'user01', 'book01', SYSDATE, SYSDATE);

SELECT *
FROM rental_list;

		SELECT COUNT(*)
		FROM rental_list
		WHERE user_id = '1'
		
		
			SELECT book_id, title, author, publisher, publish_date, rental_state
			FROM(
				SELECT rownum rnum, book_id, title, author, publisher, publish_date, rental_state
				FROM(
					SELECT book_id, title, author, publisher, publish_date, rental_state FROM book 
					WHERE title LIKE '%바다%'
					ORDER BY title DESC
				)
				WHERE rownum <= '20'
			)
			WHERE rnum >= '11'
			
			
		SELECT r.rental_no, r.user_id, r.book_id, r.rental_start, r.rental_end,
		b.book_id, b.title, b.author, b.publisher, b.publish_date, b.rental_state
		FROM rental_list r, book b
		WHERE r.book_id = b.book_id(+) AND r.user_id = '2'
		ORDER BY r.rental_start DESC
		
		
		
			SELECT rental_list.rental_no, rental_list.user_id, rental_list.book_id, rental_list.rental_start, rental_list.rental_end, 
				   book.book_id, book.title, book.author, book.publisher, book.publish_date, book.rental_state
			FROM(
				SELECT rownum rnum, rental_list.rental_no, rental_list.user_id, rental_list.book_id, rental_list.rental_start, rental_list.rental_end, 
				   book.book_id, book.title, book.author, book.publisher, book.publish_date, book.rental_state
				FROM(
					SELECT r.rental_no, r.user_id, r.book_id, r.rental_start, r.rental_end,
					b.book_id, b.title, b.author, b.publisher, b.publish_date, b.rental_state
					FROM rental_list r, book b
					WHERE r.book_id = b.book_id(+) AND r.user_id = '2'
					ORDER BY r.rental_start DESC
				)
				WHERE rownum <= '2'
			)
			WHERE rnum >= '2'
			
			
			
				SELECT rental_list.rental_no, rental_list.user_id, rental_list.book_id, rental_list.rental_start, rental_list.rental_end, 
				   book.book_id, book.title, book.author, book.publisher, book.publish_date, book.rental_state
			FROM(
				SELECT rownum rnum, rr, bb
				FROM(
					SELECT r.* rr, b.* bb
					FROM rental_list r, book b
					WHERE r.book_id = b.book_id(+) AND r.user_id = '2'
					ORDER BY r.rental_start DESC
				)
				WHERE rownum <= '2'
			)
			WHERE rnum >= '2'
			
			
			
			SELECT rrid, bbid
			FROM(
				SELECT rownum rnum, rid rrid, bid bbid
				FROM(
					SELECT r.book_id rid, b.book_id bid
					FROM rental_list r, book b
					WHERE r.book_id = b.book_id(+) AND r.user_id = '2'
					ORDER BY r.rental_start DESC
				)
				WHERE rownum <= '2'
			)
			WHERE rnum >= '2'
		
			
			
			
			
			
			
			SELECT rental_no, user_id, book_id, rental_start, rental_end, 
				   title, author, publisher, publish_date, rental_state
			FROM(
				SELECT rownum rnum,
					   rental_no_max rental_no, 
					   user_id_max user_id, 
					   book_id_max book_id, 
					   rental_start_max rental_start,
					   rental_end_max rental_end,
					   title_max title, 
					   author_max author, 
					   publisher_max publisher, 
					   publish_date_max publish_date, 
					   rental_state_max rental_state
				FROM(
					SELECT r.rental_no rental_no_max, 
						   r.user_id user_id_max, 
						   r.book_id book_id_max, 
						   r.rental_start rental_start_max,
						   r.rental_end rental_end_max,
						   b.title title_max, 
						   b.author author_max, 
						   b.publisher publisher_max, 
						   b.publish_date publish_date_max, 
						   b.rental_state rental_state_max
					FROM rental_list r, book b
					WHERE r.book_id = b.book_id(+) AND r.user_id = '2'
					ORDER BY r.rental_start DESC
				)
				WHERE rownum <= '2'
			)
			WHERE rnum >= '2'
			
			INSERT INTO rental_list VALUES(rental_no_seq.nextVal, '1', '1', '2017-05-20', NULL);
			INSERT INTO rental_list VALUES(rental_no_seq.nextVal, '3', '1', '2017-01-01', NULL);
			
			
			
			
			
			SELECT rental_no, user_id, book_id, rental_start, rental_end, 
				   title, author, publisher, publish_date, rental_state,
				   user_name
			FROM(
				SELECT rownum rnum,
					   rental_no_max rental_no, 
					   user_id_max user_id, 
					   book_id_max book_id, 
					   rental_start_max rental_start,
					   rental_end_max rental_end,
					   title_max title, 
					   author_max author, 
					   publisher_max publisher, 
					   publish_date_max publish_date, 
					   rental_state_max rental_state,
					   user_name_max user_name
				FROM(
					SELECT r.rental_no rental_no_max, 
						   r.user_id user_id_max, 
						   r.book_id book_id_max, 
						   r.rental_start rental_start_max,
						   r.rental_end rental_end_max,
						   b.title title_max, 
						   b.author author_max, 
						   b.publisher publisher_max, 
						   b.publish_date publish_date_max, 
						   b.rental_state rental_state_max,
						   u.user_name user_name_max
					FROM rental_list r, book b, user_management u
					WHERE r.book_id = b.book_id(+) AND r.user_id = u.user_id(+)
					AND r.rental_end IS NULL
					ORDER BY r.rental_start DESC
				)
				WHERE rownum <= '10'
			)
			WHERE rnum >= '1'
			
			SELECT COUNT(*)
			FROM rental_list
			WHERE rental_end IS NULL
			
			
			
			SELECT rental_no, user_id, book_id, rental_start, rental_end, 
				   title, author, publisher, publish_date, rental_state,
				   user_name
			FROM(
				SELECT rownum rnum,
					   rental_no_max rental_no, 
					   user_id_max user_id, 
					   book_id_max book_id, 
					   rental_start_max rental_start,
					   rental_end_max rental_end,
					   title_max title, 
					   author_max author, 
					   publisher_max publisher, 
					   publish_date_max publish_date, 
					   rental_state_max rental_state,
					   user_name_max user_name
				FROM(
					SELECT r.rental_no rental_no_max, 
						   r.user_id user_id_max, 
						   r.book_id book_id_max, 
						   r.rental_start rental_start_max,
						   r.rental_end rental_end_max,
						   b.title title_max, 
						   b.author author_max, 
						   b.publisher publisher_max, 
						   b.publish_date publish_date_max, 
						   b.rental_state rental_state_max,
						   u.user_name user_name_max
					FROM rental_list r, book b, user_management u
					WHERE r.book_id = b.book_id(+) AND r.user_id = u.user_id(+)
					AND r.rental_end IS NULL
					AND r.user_id = '1'
					ORDER BY r.rental_start DESC
				)
				WHERE rownum <= '10'
			)
			WHERE rnum >= '1'
			
			
			
			
SELECT *
FROM rental_list
WHERE user_id = '3'
ORDER BY rental_end DESC