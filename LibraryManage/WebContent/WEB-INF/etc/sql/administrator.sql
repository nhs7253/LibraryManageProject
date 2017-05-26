DROP TABLE administrator;

CREATE TABLE administrator(
	administrator_id VARCHAR2(30) PRIMARY KEY,
	administrator_pw VARCHAR2(30) NOT NULL,
	administrator_section CHAR(1) 
)

INSERT INTO administrator values('manager', '123456', 'Y');

DELETE FROM administrator WHERE administrator_id = 'manager'

SELECT * FROM administrator




SELECT * 
FROM (
SELECT book.*, ROW_NUMBER() OVER(ORDER BY title) AS RNUM
FROM book
WHERE book.title LIKE '%'||''||'%')