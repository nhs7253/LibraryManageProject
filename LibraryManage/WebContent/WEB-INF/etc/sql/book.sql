DROP TABLE book;

CREATE TABLE book(
	book_id VARCHAR2(30) PRIMARY KEY,
	title VARCHAR2(300) NOT NULL,
	author VARCHAR2(280) NOT NULL,
	publisher VARCHAR2(100) NOT NULL,
	publish_date VARCHAR2(30),
	rental_state CHAR(1)
);

select * from book;

select * 
from book
WHERE book_id = '1';

SELECT COUNT(*)
FROM book
WHERE title LIKE '%바다%';


SELECT * FROM (
    SELECT book.*, ROW_NUMBER() OVER(ORDER BY title ASC) AS RNUM
    FROM book
)
WHERE RNUM BETWEEN 10000 AND 11000

max = 10 * num
min = max - 9

			SELECT title
			FROM(
				SELECT rownum rnum, title
				FROM(
					SELECT title FROM book 
					WHERE title LIKE '%바다%'
					ORDER BY title DESC
				)
				WHERE rownum <= 20
			)
			WHERE rnum >= 11


SELECT     book_id,   title,   author,   publisher,   publish_date,   rental_state      
FROM(     SELECT rownum rnum,     book_id,   title,   author,   publisher,   publish_date,   rental_state        
FROM(      SELECT     book_id,   title,   author,   publisher,   publish_date,   rental_state    
FROM book ORDER BY title DESC     )     
WHERE rownum <= 20    )    
WHERE rnum >= 11

SELECT     title    
FROM(     SELECT rownum rnum,    title  
FROM(      SELECT     itle
FROM book ORDER BY title DESC     )     
WHERE rownum <= 20    )    
WHERE rnum >= 11


			SELECT book_id, title, author, publisher, publish_date, rental_state
			FROM(
				SELECT rownum rnum, book_id, title, author, publisher, publish_date, rental_state
				FROM(
					SELECT book_id, title, author, publisher, publish_date, rental_state FROM book 
					ORDER BY title DESC
				)
				WHERE rownum <= 20
			)
			WHERE rnum >= 11


SELECT Book_id , COUNT(*)
  FROM book
 GROUP BY Book_id
 HAVING COUNT(*) > 1 ;



SELECT *
FROM book;

SELECT count(*)
FROM book;

INSERT INTO book
VALUES ('1','1','1','1','1');

SELECT *
FROM book
WHERE title LIKE '%스트레스 사용설명서%';








		SELECT * FROM (
   		SELECT book.*, ROW_NUMBER() OVER(ORDER BY title) AS RNUM
    		FROM book
    		WHERE book.title LIKE '%바다%')
		WHERE RNUM BETWEEN 11 AND 20
		
		
			SELECT book_id, title, author, publisher, publish_date, rental_state
			FROM(
				SELECT rownum rnum, book_id, title, author, publisher, publish_date, rental_state
				FROM(
					SELECT book_id, title, author, publisher, publish_date, rental_state FROM book 
					WHERE title LIKE '%바다%'
					ORDER BY title
				)
				WHERE rownum <= 20
			)
			WHERE rnum >= 11
			
			
			SELECT book_id, title, author, publisher, publish_date, rental_state
			FROM(
				SELECT rownum rnum, book_id, title, author, publisher, publish_date, rental_state
				FROM(
					SELECT book_id, title, author, publisher, publish_date, rental_state FROM book 
					ORDER BY title
				)
				WHERE rownum <= 20
			)
			WHERE rnum >= 11