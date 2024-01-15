import React, { useEffect, useState } from 'react';
import ProjectBoxInfo from '../../component/project/ProjectBoxInfo';
import styled from 'styled-components';
import {useUserMemory} from '../../component/context/UserContext';

const StyledUserCreatedDiv = styled.div`
        padding-left: 20px;

        & > #cnt {
            height: 80px;
            line-height: 80px;
            color: var(--black-color);
            
            & > span {
                color: var(--red-color);
                font-weight: 500;
                margin-right: 3px;
                margin-left: 3px;
            }
        }

        & > #project_items {
            width: 1050px;
            display: flex;
            flex-wrap: wrap;
        }
`;

const UserCreated = () => {

    const {loginMemberVo} = useUserMemory();

    const [projectsCnt, setProjectsCnt] = useState(0);
    const [myProjectsList, setMyProjectsList] = useState([]);

    useEffect(()=>{
        fetch("http://127.0.0.1:8889/gamepound/userpage/created?user=" + loginMemberVo.no)
        .then(resp => resp.json())
        .then(data => {
            console.log(data);
            setMyProjectsList(data.myProjectsList);
            console.log(myProjectsList);
            setProjectsCnt(data.projectsCnt);
        });    
    }, [])

    return (
        <StyledUserCreatedDiv>
            {
                projectsCnt == 0
                ?
                <h2>올린 프로젝트가 없습니다.</h2>
                :
                <>
                    <div id="cnt">프로젝트가 <span>{projectsCnt}</span>개 있습니다.</div>
                    <div id="project_items">
                        {
                            myProjectsList.map((vo) => {
                                return <ProjectBoxInfo no={3} project={vo}/>
                            })
                        }
                    </div>
                </>
                
            }
            
        </StyledUserCreatedDiv>
    );
};

export default UserCreated;