import React, { useEffect } from 'react';
import styled from 'styled-components';
import Condition from '../../../component/search/Condition';
import { useSearchContext } from '../../../component/context/SearchContext';
import ProjectSearch from './ProjectSearch';
import { useNavigate, useParams } from 'react-router-dom';

const StyledProjectSearchDiv = styled.div`
    width: 1200px;
    margin: auto;
`;

const SearchMain = () => {
    
    const {query} = useParams();

    const {conditionVo, setConditionVo, searchedVo, setSearchedVo} = useSearchContext();

    let searchedResult;
    useEffect(()=>{

        // const searchCondition = {
        //     ...conditionVo,
        //     "query": sessionStorage.getItem('query')
        // }

        

        fetch(`http://127.0.0.1:8889/gamepound/project/search?query=${query}&status=${conditionVo.status}&achievementRate=${conditionVo.achievementRate}`)
        .then(resp => resp.json())
        .then(data => {
            setSearchedVo(data);
        })
    }, [conditionVo])

    return (
        <StyledProjectSearchDiv>
            <Condition query={query}/>
            <ProjectSearch searched={searchedVo}/>
        </StyledProjectSearchDiv>
    );
};

export default SearchMain;