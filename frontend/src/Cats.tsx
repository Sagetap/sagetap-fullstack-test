import { useCats } from "./api/cats";

const CatsList = () => {
  const { data: cats, isLoading, error } = useCats();

  if (isLoading) return <p>Loading...</p>;
  if (error) return <p>Something went wrong</p>;

  return (
    <ul>
      {cats?.map((cat) => (
        <li key={cat.id}>
          {cat.name} - {cat.breed} - {cat.age} years old
          <img
            style={{ width: '200px', height: 'auto' }}
            src={cat.url}
            alt={cat.name}
          />
        </li>
      ))}
    </ul>
  );
};

export default CatsList;
