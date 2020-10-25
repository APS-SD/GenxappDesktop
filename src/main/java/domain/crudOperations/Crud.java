package domain.crudOperations;

public abstract class Crud <T> implements CreateMixIn<T>,
													UpdateMixIn<T>,
													RetrieveMixIn<T>,
													DeleteMixIn<T>	
{

}
