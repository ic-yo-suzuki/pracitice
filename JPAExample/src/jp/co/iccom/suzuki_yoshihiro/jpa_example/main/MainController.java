package jp.co.iccom.suzuki_yoshihiro.jpa_example.main;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import jp.co.iccom.suzuki_yoshihiro.jpa_example.entity.CommentEntity;
import jp.co.iccom.suzuki_yoshihiro.jpa_example.entity.PostEntity;
import jp.co.iccom.suzuki_yoshihiro.jpa_example.entity.UserEntity;

public class MainController {

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPAExample"); // presistence.xmlの<presistence-unit>の中身と同じものを記述
		EntityManager emUser = emf.createEntityManager();
		EntityManager emPost = emf.createEntityManager();
		EntityManager emComment = emf.createEntityManager();
		// UserEntity user;
		List<UserEntity> userList = null;
		List<PostEntity> postList = null;
		List<CommentEntity> commentList = null;
		try {
			emUser.getTransaction().begin();
			long generalStart = System.currentTimeMillis();
			// UserEntity newUser = new UserEntity(1, 1, new
			// SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse("2016-06-24
			// 16:22:22"), "newuser", "新規ユーザ",
			// "602682300d465b082604f5559a85e83ab1414de9c5898191661f336e11635ea9",
			// true);
			//
			// em.persist(newUser);

			userList = emUser.createQuery("select u from UserEntity u").getResultList();

			int count = Integer.parseInt(String.valueOf(
					(long) emUser.createQuery("select count(u.id) as nop from UserEntity u").getSingleResult()));
			System.out.println("ユーザ数：" + count + "人");
			for (UserEntity user : userList) {
				if (user != null) {
					System.out.println("====================================");
					System.out.println("取得できたユーザの情報");
					System.out.println("------------------------------------");
					System.out.println("ユーザID：" + user.getId());
					System.out.println("名前：" + user.getName());
					System.out.println("ログインID：" + user.getLoginId());
					System.out.println("所属：" + user.getBranch().getName() + " " + user.getDepartment().getName());
					System.out.println("------------------------------------");
					System.out.println("このユーザの投稿一覧");

					emPost.getTransaction().begin();
					postList = emPost.createQuery("select p from PostEntity p where p.user.id = " + user.getId())
							.getResultList();
					if (postList.size() != 0) {
						for (PostEntity post : postList) {
							System.out.println("------------------------------------");
							System.out.println("投稿ID：" + post.getId());
							System.out.println("投稿者：" + post.getUser().getName());
							System.out.println("タイトル：" + post.getTitle());
							System.out.println("カテゴリ：" + post.getCategory());
							System.out.println("投稿日時：" + post.getInsertDate());
							System.out.println("本文：" + post.getText());
							System.out.println("------------------------------------");
							System.out.println("この投稿に対するコメント一覧");
							emComment.getTransaction().begin();
							commentList = emComment
									.createQuery("select c from CommentEntity c where c.post.id = " + post.getId())
									.getResultList();
							if (commentList.size() != 0) {
								for (CommentEntity comment : commentList) {
									System.out.println("------------------------------------");
									System.out.println("コメントID：" + comment.getId());
									System.out.println("投稿者：" + comment.getPost().getUser().getName());
									System.out.println("投稿日時：" + comment.getInsertDate());
									System.out.println("本文：" + comment.getText());
								}
								System.out.println("------------------------------------");
								System.out.println("コメント件数：" + commentList.size() + "件");
							} else {
								System.out.println("------------------------------------");
								System.out.println("投稿なし");
							}
							emComment.getTransaction().commit();
						}
						System.out.println("------------------------------------");
						System.out.println("投稿件数：" + postList.size() + "件");
					} else {
						System.out.println("------------------------------------");
						System.out.println("投稿なし");
					}
					emPost.getTransaction().commit();
				}
				System.out.println("");
			}

			long generalFinish = System.currentTimeMillis();
			System.out.println("====================================");
			System.out.println("全体所要時間：" + (((double) (generalFinish - generalStart)) / 1000) + "[s]");
			emUser.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			if (emUser.getTransaction().isActive()) {
				emUser.getTransaction().rollback();
			}
			if (emPost.getTransaction().isActive()) {
				emPost.getTransaction().rollback();
			}
			if (emComment.getTransaction().isActive()) {
				emComment.getTransaction().rollback();
			}
		} finally {

		}

	}

}
