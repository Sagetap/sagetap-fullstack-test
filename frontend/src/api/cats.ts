import { useQuery } from '@tanstack/react-query';
import axios from 'axios';

export type Cat = {
  id: number;
  name: string;
  breed: string;
  age: number;
  url: string;
};



export const useCats = () => {
  const getCats = async (): Promise<Cat[]> => {
    const response = await axios.get('/cats');
    return response.data;
  };
  return useQuery({
    queryKey: ['cats'],
    queryFn: getCats,
  });
};
