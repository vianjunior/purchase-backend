package com.junior.purchaseworkflow.service;

import com.google.gson.Gson;
import com.junior.purchaseworkflow.PurchaseEntityManager;
import com.junior.purchaseworkflow.dao.PurchaseDAO;
import com.junior.purchaseworkflow.model.Filter;
import com.junior.purchaseworkflow.model.Purchase;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import org.json.JSONObject;

public class PurchaseWorkflowService
{

	private static EntityManager em = PurchaseEntityManager.getEntityManager();
	public static PurchaseDAO purchaseDAO = new PurchaseDAO();

	public static JSONObject create(String purchaseJson) {

		Gson gson = new Gson();
		Purchase purchase = gson.fromJson(purchaseJson, Purchase.class);

		purchaseDAO.create(purchase);

		JSONObject retorno = new JSONObject();
		retorno.put("retorno", "Create");

		return retorno;
	}

	public static JSONObject update(String purchaseJson) {

		Gson gson = new Gson();
		Purchase purchase = gson.fromJson(purchaseJson, Purchase.class);

		purchaseDAO.update(purchase);

		JSONObject retorno = new JSONObject();
		retorno.put("retorno", "ReadAll");

		return retorno;
	}

	public static List<Purchase> getPendingTasks(String filterParams) {

		Gson gson = new Gson();
		Filter filter = gson.fromJson(filterParams, Filter.class);

		CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
		CriteriaQuery<Purchase> criteriaQuery = criteriaBuilder.createQuery(Purchase.class);
		Root<Purchase> root = criteriaQuery.from(Purchase.class);

		criteriaQuery.select(root);
		criteriaQuery.where(criteriaBuilder.equal(root.get("hasApproval"), false));
		TypedQuery<Purchase> typedQuery = em.createQuery(criteriaQuery);
		List<Purchase> purchases = purchaseDAO.getTasksByFilter(typedQuery);

		return purchases;
	}

	public static Purchase getTaskById(Long id) {

		return purchaseDAO.getById(id);
	}

	public static List<Purchase> getAllTasks(String filterParams) {
		Gson gson = new Gson();
		Filter filter = gson.fromJson(filterParams, Filter.class);

		CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
		CriteriaQuery<Purchase> criteriaQuery = criteriaBuilder.createQuery(Purchase.class);
		Root<Purchase> root = criteriaQuery.from(Purchase.class);

		criteriaQuery.select(root);
		TypedQuery<Purchase> typedQuery = em.createQuery(criteriaQuery);
		List<Purchase> purchases = purchaseDAO.getTasksByFilter(typedQuery);

		return purchases;
	}
}