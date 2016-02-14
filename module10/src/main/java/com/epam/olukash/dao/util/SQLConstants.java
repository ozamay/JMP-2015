package main.java.com.epam.olukash.dao.util;

/**
 * @author Oleksii.Lukash
 */
public class SQLConstants
{
	// Create table
	public static final String SQL_CREATE_TABLE_USER = "CREATE TABLE USERS (USERID NUMBER NOT NULL, "
			+ "  USERNAME NVARCHAR2(100) NOT NULL, USERSURNAME NVARCHAR2(100) NOT NULL, BIRTHDAY TIMESTAMP NOT NULL)";
	public static final String SQL_CREATE_TABLE_FRIENDSHIPS  = "CREATE TABLE FRIENDSHIP (USERID1 NUMBER NOT NULL, "
			+ " USERID2 NUMBER NOT NULL, CREATEDATE TIMESTAMP NOT NULL )";
	public static final String SQL_CREATE_TABLE_LIKES  = "CREATE TABLE LIKES (POSTID NUMBER NOT NULL, "
			+ " USERID NUMBER NOT NULL, CREATEDATE TIMESTAMP NOT NULL )";
	public static final String SQL_CREATE_TABLE_POSTS  = "CREATE TABLE POSTS (POSTID NUMBER NOT NULL, "
			+ " USERID NUMBER NOT NULL, POSTTEXT NVARCHAR2(100) NOT NULL, CREATEDATE TIMESTAMP NOT NULL )";

	// Drop table
	public static final String SQL_DROP_POSTS  = "DECLARE cnt int; BEGIN SELECT COUNT(*) INTO cnt FROM user_tables WHERE table_name = 'POSTS'; "
			+ "  IF cnt > 0 THEN EXECUTE IMMEDIATE 'DROP TABLE POSTS'; END IF; END;";
	public static final String SQL_DROP_LIKES  = "DECLARE cnt int; BEGIN SELECT COUNT(*) INTO cnt FROM user_tables WHERE table_name = 'LIKES'; "
			+ "  IF cnt > 0 THEN EXECUTE IMMEDIATE 'DROP TABLE LIKES'; END IF; END;";
	public static final String SQL_DROP_USER  = "DECLARE cnt int; BEGIN SELECT COUNT(*) INTO cnt FROM user_tables WHERE table_name = 'USERS'; "
			+ "  IF cnt > 0 THEN EXECUTE IMMEDIATE 'DROP TABLE USERS'; END IF; END;";
	public static final String SQL_DROP_FRIENDSHIPS  = "DECLARE cnt int; BEGIN SELECT COUNT(*) INTO cnt FROM user_tables WHERE table_name = 'FRIENDSHIP'; "
			+ "  IF cnt > 0 THEN EXECUTE IMMEDIATE 'DROP TABLE FRIENDSHIP'; END IF; END;";

	// Insert
	public static final String SQL_CREATE_USER = "INSERT INTO USERS (USERID, USERNAME, USERSURNAME, BIRTHDAY) VALUES (?, ?, ?, ?)";
	public static final String SQL_CREATE_FRIENDSHIP = "INSERT INTO FRIENDSHIP (USERID1, USERID2, CREATEDATE) VALUES (?, ?, ?)";
	public static final String SQL_CREATE_POST = "INSERT INTO POSTS (POSTID, USERID, POSTTEXT, CREATEDATE) VALUES (?, ?, ?, ?)";
	public static final String SQL_CREATE_LIKE = "INSERT INTO LIKES (POSTID, USERID, CREATEDATE) VALUES (?, ?, ?)";

	// Other queries
	public static final String SQL_GET_USER_BY_COUNT_OF_LIKES_AND_FRIENDS =
			"WITH counts as "
					+ "("
					+ "  SELECT"
					+ "      u.USERID as USERID,"
					+ "      (SELECT COUNT(*) FROM FRIENDSHIPS fs WHERE fs.USERID1 = u.USERID) as friendCount,"
					+ "      (SELECT COUNT(*) FROM LIKES l INNER JOIN POSTS p ON p.POSTID = l.POSTID WHERE p.USERID = u.USERID) as likeCount"
					+ "  FROM "
					+ "      USERS u"
					+ ")"
					+ "SELECT  "
					+ "      u.USERID,"
					+ "      u.USERNAME,"
					+ "      u.USERSURNAME,"
					+ "      u.BIRTHDAY "
					+ "FROM "
					+ "      USERS u INNER JOIN counts c on c.USERID = u.USERID "
					+ "WHERE"
					+ "      c.friendCount > ?"
					+ "      AND c.likeCount > ?";
}
