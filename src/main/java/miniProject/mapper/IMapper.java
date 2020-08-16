package miniProject.mapper;

public interface IMapper<E, D> {
	public E toEntity(D dto);

	public D toDto(E entity);
}
