package BoardGame.entity;




public interface UserDao {
	int insert(Notification notification);

	User findByUserName(String userName);

	byte[] getImage(int id);

}
