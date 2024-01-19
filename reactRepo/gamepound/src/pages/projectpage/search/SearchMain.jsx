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

    const navigate = useNavigate();
    const {setSearchedVo} = useSearchContext();

    useEffect(()=>{
        
        if(sessionStorage.getItem('query')) {
            fetch("http://127.0.0.1:8889/gamepound/project/search?query=" + sessionStorage.getItem('query'))
            .then(resp => resp.json())
            .then(data => {
                
                setSearchedVo({
                    data
                });
                
                navigate("/project/search/"+sessionStorage.getItem('query'));
                
            });
        } else if(sessionStorage.getItem('query') === undefined){
            
        } else {

        }
    }, [])

    return (
        <StyledProjectSearchDiv>
            <Condition query={query}/>
            <ProjectSearch />
        </StyledProjectSearchDiv>
    );
};

export default SearchMain;