package controller.crudOperations;

public abstract class CrudController <T> implements CreateMixIn<T>,
													UpdateMixIn<T>,
													RetrieveMixIn<T>,
													DeleteMixIn<T>	
{

}
