package Interfaces;

import RepositoryMvk.Data.MvkResponse;

public interface IRepositoryMvk {
    MvkResponse GetResponse() throws Exception;
}