import React from 'react';
import styled from 'styled-components';
import ProjectBoxInfo from "../../../component/project/ProjectBoxInfo";

const StyledAllDiv = styled.div`
    width: 100%;
    .inner {
        width: 1200px;
        margin: 0 auto;
        & > div:first-child{
            & > div:last-child{
                & > span{
                    color: var(--red-color);
                }
                margin-top: 20px;
                margin-bottom: 25px;
            }
            
        }
        & > div:last-child{
            display: flex;
            flex-wrap: wrap;
        }
    }
`;

const PrelaunchPage = () => {
    return (
        <StyledAllDiv>
            <div className='inner'>
                <div>
                    <div><span>20</span>개의 프로젝트가 있습니다.</div>
                </div>
                <div>
                    <ProjectBoxInfo no={1} project={1}/>
                    <ProjectBoxInfo no={1} project={1}/>
                    <ProjectBoxInfo no={1} project={1}/>
                    <ProjectBoxInfo no={1} project={1}/>
                    <ProjectBoxInfo no={1} project={1}/>
                </div>
            </div>
        </StyledAllDiv>
    );
};

export default PrelaunchPage;